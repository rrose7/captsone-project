import { Component, OnInit } from '@angular/core';
import {CategoriesService} from "../../services/categories.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  categories = [];

  constructor(private categoryService: CategoriesService) {
  }

  ngOnInit(): void {
    this.categoryService.getCategories().subscribe((data) => {
      console.log(data);
      this.categories = data;
    } );
  }
}
