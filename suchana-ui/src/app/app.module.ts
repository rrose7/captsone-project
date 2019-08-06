import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewsComponent } from './components/news/news.component';
import { SportsComponent } from './components/sports/sports.component';
import { PoliticsComponent } from './components/politics/politics.component';
import {HttpClientModule} from "@angular/common/http";
import { EntertainmentComponent } from './components/entertainment/entertainment.component';
import {AdminModule} from "./components/admin/admin.module";
import { HeaderComponent } from './components/header/header.component';
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import {AuthModule} from "./components/auth/auth.module";






@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    SportsComponent,
    PoliticsComponent,
    EntertainmentComponent,
    HeaderComponent





  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AdminModule,
    AuthModule,
    NgMultiSelectDropDownModule.forRoot()


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
