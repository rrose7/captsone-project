import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../services/category.service";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  private categories=[];

  constructor(private categoryService: CategoryService) { }

  ngOnInit() {
  this.categoryService.getCategories().subscribe(data=>this.categories = data)
  }

}
