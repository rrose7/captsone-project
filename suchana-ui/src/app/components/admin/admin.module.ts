import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";
import {AdminRoutingModule} from "./admin-routing.module";
import {CategoriesComponent} from "./categories/categories.component";
import {AdminComponent} from "./admin.component";



@NgModule({
  declarations: [CategoriesComponent, AdminComponent],
  imports: [
    CommonModule,
    FormsModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
