import { Component, OnInit } from '@angular/core';
import {AuthorService} from "../../../../services/author.service";
import {Author} from "../../../../models/author";
import {CategoriesService} from "../../../../services/categories.service";

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  authors = [];
  categories=[];


  author:Author;
  addauthor: Author;
  constructor(private authorService: AuthorService, private categoriesService: CategoriesService) { }
  ngOnInit() {
    this.getAuthor();
    this.getCategories();

  }
  getCategories(){
  this.categoriesService.getCategories().subscribe(data=>{
    this.categories=data});
  }
  getAuthor(){
    this.authorService.getAuthor().subscribe(data=>{
      this.authors=data
    });
  }
  editAuthor(author){
    this.author= author;
  }
  submitAuthorEdit(){
    this.authorService.updateAuthor(this.author).subscribe(()=>this.getAuthor());
    this.author = null;
  }
  createAuthorAdd(){
    this.authorService.createAuthor(this.addauthor).subscribe((data)=>this.authors.push(data));
    this.addauthor = null;

  }
  cancel(){
    this.author = null;
  }

  createAuthorForm(){
    this.addauthor = new Author();


  }
}
