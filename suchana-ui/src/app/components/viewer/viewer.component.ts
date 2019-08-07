import { Component, OnInit } from '@angular/core';
import {CategoriesService} from "../../services/categories.service";

@Component({
  selector: 'app-viewer',
  templateUrl: './viewer.component.html',
  styleUrls: ['./viewer.component.css']
})
export class ViewerComponent implements OnInit {
  categories: [];

  constructor(private categoriesService: CategoriesService) { }

  ngOnInit(): void {
this.categoriesService.getCategories().subscribe((data)=>{
  console.log(data);
  this.categories =data;
})

  }

}
