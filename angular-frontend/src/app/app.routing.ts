import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PingComponent } from './ping/ping.component';
import { HomeComponent } from './home/home.component';
import { DialogItemComponent } from './dialogItem/dialogItem.component';

const appRoutes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'ping', component: PingComponent},
    {path: 'dialogItemSingle', component: DialogItemComponent}
];

export const appRouterProviders: any[] = [];

export const routing: ModuleWithProviders =
  RouterModule.forRoot(appRoutes);
