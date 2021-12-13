import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { RouterModule } from '@angular/router';
import { MatExpansionModule } from '@angular/material/expansion';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './components/forms/signup/signup.component';
import { LoginComponent } from './components/forms/login/login.component';
import { GameListComponent } from './components/games/game-list/game-list.component';
import { GameCardComponent } from './components/games/game-card/game-card.component';
import { UserProfileComponent } from './components/user/user-profile/user-profile.component';
import { MatchingRequestComponent } from './components/forms/matching-request/matching-request.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { MatchingRequestListComponent } from './components/matching/matching-request-list/matching-request-list.component';
import { MatchingRequestCardComponent } from './components/matching/matching-request-card/matching-request-card.component';
import { EditProfileComponent } from './components/user/edit-profile/edit-profile.component';
import { FriendListComponent } from './components/friends/friend-list/friend-list.component';
import { UserComponent } from './components/user/user/user.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FooterComponent } from './components/footer/footer.component';
import { AboutComponent } from './components/about/about.component';
@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    GameListComponent,
    GameCardComponent,
    UserProfileComponent,
    MatchingRequestComponent,
    NavbarComponent,
    NotfoundComponent,
    MatchingRequestListComponent,
    MatchingRequestCardComponent,
    EditProfileComponent,
    FriendListComponent,
    UserComponent,
    FooterComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    SweetAlert2Module,
    RouterModule,
    MatExpansionModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
