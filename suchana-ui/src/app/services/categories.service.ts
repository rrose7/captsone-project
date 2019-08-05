import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Constants} from "../models/Constants";


@Injectable({
  providedIn: 'root'
})
export class CategoriesService {
  API_URL = Constants.API_BASE_URL + "/categories";

  constructor(private http: HttpClient) { }

  getCategories(): Observable<any> {
    return this.http.get(this.API_URL);
  }
  updateCategories(categories):Observable<any>{
    return this.http.put(this.API_URL + "/" + categories.id, categories);
  }
  deleteCategories(id):Observable<any>{
    return this.http.delete(this.API_URL+"/"+ id);

  }
  createCategories(categories):Observable<any>{
    return this.http.post(this.API_URL, categories);
  }


}
