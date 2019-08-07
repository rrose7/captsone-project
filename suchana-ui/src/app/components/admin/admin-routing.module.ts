import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AdminComponent} from "./admin.component";
import {AuthorComponent} from "./authors/author/author.component";
import {CategoriesComponent} from "./categories/categories.component";
import {CanActivateGuard} from "../../services/can-activate.guard";

const routes: Routes=[
  {
    path:'admin',
    component: AdminComponent,
    canActivate:[CanActivateGuard],
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
