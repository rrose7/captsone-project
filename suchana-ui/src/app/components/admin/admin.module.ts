import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";
import {AdminRoutingModule} from "./admin-routing.module";
import {CategoriesComponent} from "./categories/categories.component";
import {AdminComponent} from "./admin.component";
import { AuthorComponent } from './author/author.component';



@NgModule({
  declarations: [CategoriesComponent, AdminComponent, AuthorComponent],
  imports: [
    CommonModule,
    FormsModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
