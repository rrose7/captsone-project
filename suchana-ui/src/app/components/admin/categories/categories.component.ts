import { Component, OnInit } from '@angular/core';
import {CategoriesService} from "../../../services/categories.service";
import {categories} from "../../../models/categories.model";

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories = [];

  editingCategories = false;
  categoriesToEdit;
  creatingCategories = false;
  categoriesToCreate;
  constructor(private categoryService: CategoriesService) { }
  ngOnInit() {
    this.getCategories();
  }
  getCategories(){
    this.categoryService.getCategories().subscribe((data)=>this.categories=data);
  }
  editCategories(categories){
    console.log(categories.toString());
    this.editingCategories = true;
    this.categoriesToEdit = categories;
  }
  submitCategoriesEdit(categories){
    this.editingCategories= false;
    this.categoryService.updateCategories(categories).subscribe((data)=>this.categories= data);
    this.cancel();
  }
  deleteCategories(categories){
    this.categoryService.deleteCategories(categories.id).subscribe(data=> {
      this.categories=data;
      this.getCategories();
    });

  }
  createCategoriesForm(){
    this.creatingCategories = true;
    this.categoriesToCreate =new categories();
  }
  createCategories(categories){
    this.categoryService.createCategories(categories).subscribe((data)=>this.categories.push(data));
this.cancel();

  }
  cancel(){
    this.editingCategories =false;
    this.creatingCategories = false;
  }
}
