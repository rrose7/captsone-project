import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";
import {AdminRoutingModule} from "./admin-routing.module";
import {AdminComponent} from "./admin.component";
import { AuthorComponent } from './authors/author/author.component';
import { EditAuthorComponent } from './authors/edit-author/edit-author.component';
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import { AddAuthorComponent } from './authors/add-author/add-author.component';
import { CategoriesComponent } from './categories/categories.component';
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {ApiService} from "../interceptors/api.service";



@NgModule({
  declarations: [AdminComponent, AuthorComponent, EditAuthorComponent, AddAuthorComponent, CategoriesComponent],
  imports: [
    CommonModule,
    FormsModule,
    AdminRoutingModule,
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers:[{
    provide: HTTP_INTERCEPTORS, useClass: ApiService, multi: true
  }]
})
export class AdminModule { }
