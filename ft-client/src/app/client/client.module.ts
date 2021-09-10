import { MatPaginatorModule } from '@angular/material/paginator';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { ClientRoutingModule } from './client-routing.module';
import { LayoutComponent } from './layout.component';
import { ListComponent } from './list/list.component';
import { EditComponent } from './edit/edit.component';

@NgModule({
    imports: [
        ClientRoutingModule,
        ReactiveFormsModule,
        CommonModule,
        MatPaginatorModule,
    ],
    declarations: [
        LayoutComponent,
        ListComponent,
        EditComponent
    ]
})
export class ClientModule { }