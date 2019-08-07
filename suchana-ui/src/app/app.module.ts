import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {AdminModule} from "./components/admin/admin.module";
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import {AuthModule} from "./components/auth/auth.module";
import {UnauthorizedComponent} from "./components/unauthorized/unauthorized.component";
import {ViewerModule} from "./components/viewer/viewer.module";
import {AuthorssModule} from "./components/authorss/authorss.module";

@NgModule({
  declarations: [
    AppComponent,
    UnauthorizedComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AdminModule,
    AuthModule,
    ViewerModule,
    AuthorssModule,
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
