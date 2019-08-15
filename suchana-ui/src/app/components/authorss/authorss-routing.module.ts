import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AuthorCanActivateGuard} from "../../services/author-can-activate.guard";
import {ArticlesComponent} from "./articles/articles.component";
import {AuthorssComponent} from "./authorss.component";


const routes: Routes = [
  {
    path: 'author',
    component: AuthorssComponent,
    canActivate: [AuthorCanActivateGuard],
    children: [
      {
        path: 'articles',
        component: ArticlesComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AuthorssRoutingModule { }
