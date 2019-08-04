import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AdminComponent} from "./admin.component";
import {CategoriesComponent} from "./categories/categories.component";
import {AuthorComponent} from "./author/author.component";

const routes: Routes=[
  {
    path:'admin',
    component: AdminComponent,
    children:[
      {
        path:'categories',
        component:CategoriesComponent
      },
      {
        path:'authors',
        component:AuthorComponent
      }
    ]
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AdminRoutingModule { }
