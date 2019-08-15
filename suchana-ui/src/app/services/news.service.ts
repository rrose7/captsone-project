import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Constants} from "../models/Constants";

@Injectable({
  providedIn: 'root'
})
export class NewsService {
  // inject httpClient into service
  constructor(private http: HttpClient) { }

  getNews(category?: string): Observable<any> {
    let url = Constants.API_BASE_URL + "/articles";

    if (category) {
      url = url + "?category=" + category;
    }
    return this.http.get(url);
  }
}
