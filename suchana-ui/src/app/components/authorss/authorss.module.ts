import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AuthorssComponent} from "./authorss.component";
import {ArticlesComponent} from "./articles/articles.component";
import {AuthorssRoutingModule} from "./authorss-routing.module";
import {FormsModule} from "@angular/forms";




@NgModule({
  declarations: [AuthorssComponent, ArticlesComponent],
  imports: [
    CommonModule,
    FormsModule,
    AuthorssRoutingModule

  ]
})
export class AuthorssModule { }
