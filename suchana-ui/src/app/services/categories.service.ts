import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {categories} from "../models/categories.model";

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {
  API_BASE_URL = "http://localhost:8080";

  constructor(private http: HttpClient) {
  }

  getCategories(): Observable<any> {
    return this.http.get(this.API_BASE_URL + "/categories");
  }
  updateCategories(categories):Observable<any>{
  return this.http.put(this.API_BASE_URL + "/categories/" + categories.id, categories);
  }
  deleteCategories(id):Observable<any>{
  return this.http.delete(this.API_BASE_URL+"/categories/"+ id);

  }
  createCategories(categories):Observable<any>{
    return this.http.post(this.API_BASE_URL+"/categories/", categories);
  }

}
