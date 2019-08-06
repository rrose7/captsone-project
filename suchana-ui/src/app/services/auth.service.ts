import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Constants} from "../models/Constants";
import {LoginRequest} from "../models/LoginRequest";


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient){}
  login(user:LoginRequest):Observable<any>{
return this.http.post(Constants.API_BASE_URL +"/user/login", user);
  }

}
