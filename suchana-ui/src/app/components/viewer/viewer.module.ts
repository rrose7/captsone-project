import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ViewerComponent} from './viewer.component';
import {ViewerRoutingModule} from "./viewer-routing.module";
import {NewsComponent} from "../news/news.component";
import {PoliticsComponent} from "../politics/politics.component";
import {SportsComponent} from "../sports/sports.component";
import {HomeComponent} from "../home/home.component";
import {EntertainmentComponent} from "../entertainment/entertainment.component";

@NgModule({
  declarations: [ViewerComponent,
    NewsComponent,
    SportsComponent,
    PoliticsComponent,
    EntertainmentComponent,
    HomeComponent
  ],
  imports: [
    CommonModule,
    ViewerRoutingModule
  ]
})
export class ViewerModule {
}
