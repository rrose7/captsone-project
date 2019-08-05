import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AdminComponent} from "./admin.component";
import {AuthorComponent} from "./authors/author/author.component";
import {CategoriesComponent} from "./categories/categories.component";

const routes: Routes=[
  {
    path:'admin',
    component: AdminComponent,
    children:[
      {
        path:'authors',
        component:AuthorComponent
      },
      {
        path: 'categories',
        component: CategoriesComponent
      }
    ]
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AdminRoutingModule { }
