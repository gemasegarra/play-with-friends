import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/forms/login/login.component';
import { MatchingRequestComponent } from './components/forms/matching-request/matching-request.component';
import { SignupComponent } from './components/forms/signup/signup.component';
import { GameCardComponent } from './components/games/game-card/game-card.component';
import { GameListComponent } from './components/games/game-list/game-list.component';
import { MatchingRequestCardComponent } from './components/matching/matching-request-card/matching-request-card.component';
import { MatchingRequestListComponent } from './components/matching/matching-request-list/matching-request-list.component';
import { UserProfileComponent } from './components/user/user-profile/user-profile.component';
import { UserComponent } from './components/user/user/user.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'games',
    component: GameListComponent
  },
  {
    path: 'games/:id',
    component: GameCardComponent
  },
  {
    path: 'matching',
    component: MatchingRequestComponent
  },
  {
    path: 'matchinglist',
    component: MatchingRequestListComponent
  },
  {
    path: 'matching/:id',
    component: MatchingRequestCardComponent
  },
  {
    path: 'profile',
    component: UserProfileComponent
  },
  {
    path: 'users/:id',
    component: UserComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
