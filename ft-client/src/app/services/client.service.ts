import { Client } from '../models/client';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '@environments/environment';
import { Observable, of } from 'rxjs';

const baseUrl = `${environment.apiUrl}`;

@Injectable({ providedIn: 'root' })
export class ClientService {
    constructor(private http: HttpClient) { }

    getAllPage(page: number, size:number) {
        return this.http.get<any>(`${baseUrl}?page=${page}&size=${size}`);
    }
    getParam(param: string, page: number, size:number) {
        return this.http.get<any>(`${baseUrl}/find?param=${param}&page=${page}&size=${size}`);
    }

    getById(id: string) {
        return this.http.get<any>(`${baseUrl}/${id}`);
    }

    create(params: any) {
        return this.http.post(baseUrl, params);
    }

    update(id: string, params: any) {
        return this.http.put(`${baseUrl}/${id}`, params);
    }

    delete(id: string) {
        return this.http.delete(`${baseUrl}/${id}`);
    }
}