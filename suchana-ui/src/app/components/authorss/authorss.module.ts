import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AuthorssComponent} from "./authorss.component";
import {ArticlesComponent} from "./articles/articles.component";
import {AuthorssRoutingModule} from "./authorss-routing.module";
import {FormsModule} from "@angular/forms";
import {EditArticleComponent} from "./edit-article/edit-article.component";



@NgModule({
  declarations: [AuthorssComponent, ArticlesComponent, EditArticleComponent],
  imports: [
    CommonModule,
    FormsModule,
    AuthorssRoutingModule

  ]
})
export class AuthorssModule { }
