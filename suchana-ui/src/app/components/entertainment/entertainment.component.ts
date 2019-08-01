import { Component, OnInit } from '@angular/core';
import {NewsService} from "../../services/news.service";

@Component({
  selector: 'app-entertainment',
  templateUrl: './entertainment.component.html',
  styleUrls: ['./entertainment.component.css']
})
export class EntertainmentComponent implements OnInit {
  entertainmentNews=[];
  constructor(private newsService:NewsService) { }

  ngOnInit() {
    this.newsService.getEntertainmentNew().subscribe((data)=>this.entertainmentNews=data);
  }

}
