import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable, ReplaySubject} from "rxjs";
import {Constants} from "../models/Constants";
import {LoginRequest} from "../models/LoginRequest";


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedInEvent = new ReplaySubject<any>();

  constructor(private http: HttpClient) { }

  login(user: LoginRequest): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });
    const body = new HttpParams()
      .set('username', user.username)
      .set('password', user.password);
    return this.http.post(Constants.API_BASE_URL + "/user/login", body.toString(), {headers});
  }

  loggedInUser() {
    return JSON.parse(localStorage.getItem('loggedInUser'));
  }

  isLoggedIn(): Observable<any> {
    if (localStorage.getItem('loggedInUser') != null) {
      this.loggedInEvent.next({type: 'success'});
    }
    return this.loggedInEvent.asObservable();
  }

  logout() {
    localStorage.removeItem('loggedInUser');
    this.loggedInEvent.next({type : 'error'});
  }
}
