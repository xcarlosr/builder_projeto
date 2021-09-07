import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const clientsModule = () => import('./client/client.module').then(x => x.ClientModule);

const routes: Routes = [
    { path: 'client', loadChildren: clientsModule },

    { path: '**', redirectTo: 'client' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }