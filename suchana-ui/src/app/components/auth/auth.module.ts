import {NgModule} from "@angular/core";
import {AuthComponent} from "./auth.component";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AuthRoutingModule} from "./auth-routing.module";

@NgModule({
      declarations:[AuthComponent],
      imports:[
        CommonModule,
        AuthRoutingModule,
        FormsModule
      ]
})
export class AuthModule{}
