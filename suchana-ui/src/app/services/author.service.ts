import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  API_BASE_URL = "http://localhost:8080";

  constructor(private http: HttpClient) {
  }

  getAuthor(): Observable<any> {
    return this.http.get(this.API_BASE_URL + "/authors");
  }
  updateAuthor(authors):Observable<any>{
    return this.http.put(this.API_BASE_URL + "/authors/" + authors.id, authors);
  }
  deleteAuthor(id):Observable<any>{
    return this.http.delete(this.API_BASE_URL+"/authors/"+ id);

  }
  createAuthor(authors):Observable<any>{
    return this.http.post(this.API_BASE_URL+"/authors/", authors);
  }

}
