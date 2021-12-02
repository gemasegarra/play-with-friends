import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/forms/login/login.component';
import { MatchingRequestComponent } from './components/forms/matching-request/matching-request.component';
import { SignupComponent } from './components/forms/signup/signup.component';
import { GameListComponent } from './components/games/game-list/game-list.component';

const routes: Routes = [
  
  { path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  { path: 'games',
    component: GameListComponent},
  { path: 'matching',
    component: MatchingRequestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
