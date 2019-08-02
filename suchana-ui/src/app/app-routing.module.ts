import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NewsComponent} from "./components/news/news.component";
import {SportsComponent} from "./components/sports/sports.component";
import {PoliticsComponent} from "./components/politics/politics.component";
import {EntertainmentComponent} from "./components/entertainment/entertainment.component";
import {CategoryComponent} from "./components/category/category.component";


const routes: Routes = [
  {
    path: "news",
    component:NewsComponent
  },
  {
    path: "sports",
    component:SportsComponent
  },
  {
    path: "politics",
    component:PoliticsComponent
  },
  {
    path: "entertainment",
    component:EntertainmentComponent
  },
  {
    path: "category",
    component:CategoryComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
