import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { ClientService } from '../../services/client.service';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';

import { Client } from '@app/models';
import { FormControl } from '@angular/forms';

@Component({ templateUrl: 'list.component.html' })
export class ListComponent implements OnInit, AfterViewInit {
    
    @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
    
    formSearch = new FormControl();
    pageIndex = 0;
    pageSize = 5;
    totalPages = 0;
    totalElements=10;
    showFirstLastButtons = true;
    pageSizeOptions = [5, 10, 25, 100];
  
    clients!: Client[];
    loading = false;

    constructor(private clientService: ClientService) { }

    ngOnInit() {
        this.findAll();
    }

    findAll() {
        this.clientService.getAllPage( this.pageIndex, this.pageSize)
            .subscribe(req => {
                this.resultBuild(req);
            });
    }

    findParam() {
        if(this.formSearch.value){
            const param = this.formSearch.value.trim();
            this.clientService.getParam(param, this.pageIndex, this.pageSize)
            .subscribe(req => {
                this.resultBuild(req);
            });
        } else {
            this.findAll();
        }
    }

    private resultBuild(req: any) {
        this.clients = req.data.content;
        this.pageIndex = req.data.pageable.pageNumber;
        this.pageSize = req.data.pageable.pageSize;
        this.totalPages = req.data.totalPages;
        this.totalElements = req.data.totalElements;
    }

    delete(id: string) {
        const client = this.clients.find(x => x.id === id);
        if (!client) return;
        this.clientService.delete(id)
            .subscribe(() => this.clients = this.clients.filter(x => x.id !== id));
    }

    nextPage(event:PageEvent): void {
        this.pageIndex = event.pageIndex;
        this.pageSize = event.pageSize;
        this.findAll();
    }


    ngAfterViewInit() {
        this.paginator = this.paginator;
    }
}