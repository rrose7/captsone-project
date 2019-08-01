import { Component, OnInit } from '@angular/core';
import {NewsService} from "../../services/news.service";

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit{
  allNews = [];

  constructor(private newsService: NewsService) { }

  ngOnInit() {
  this.newsService.getAllNews().subscribe((data)=> this.allNews = data);
  }

}
