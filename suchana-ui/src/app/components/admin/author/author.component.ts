import { Component, OnInit } from '@angular/core';
import {AuthorService} from "../../../services/author.service";
import {Author} from "../../../models/author";

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  authors = [];

  editingAuthor = false;
  authorToEdit;
  creatingAuthor = false;
  authorToCreate;
  constructor(private authorService: AuthorService) { }
  ngOnInit() {
    this.getAuthor();

  }
  getAuthor(){
    this.authorService.getAuthor().subscribe((data)=>this.authors=data);
  }
  editAuthor(authors){
    this.editingAuthor = true;
    this.authorToEdit = authors;
  }
  submitAuthorEdit(author){
    this.editingAuthor= false;
    this.authorService.updateAuthor(author).subscribe((data)=>this.authors= data);
  }
  deleteAuthor(author){
    this.authorService.deleteAuthor(author.id).subscribe((data)=>this.authors=data);
  }
  createAuthorForm(){
    this.creatingAuthor = true;
    this.authorToCreate =new Author();
  }
  createAuthor(author){
    this.authorService.createAuthor(author).subscribe((data)=>this.authors.push(data));


  }
  cancel(){
    this.editingAuthor =false;
    this.creatingAuthor = false;
  }
}
