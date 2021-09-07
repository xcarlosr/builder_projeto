import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { ClientService, AlertService } from '@app/services';

@Component({ templateUrl: 'edit.component.html' })
export class EditComponent implements OnInit {
    form!: FormGroup;
    id!: string;
    isAddClient!: boolean;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private clientService: ClientService,
        private alertService: AlertService
    ) {}

    ngOnInit() {
        this.id = this.route.snapshot.params['id'];
        this.isAddClient = !this.id;

        this.form = this.formBuilder.group({
          nome: ['', Validators.required],
          email: ['', Validators.required],
          idade: ['', Validators.required],
        });

        if(!this.isAddClient) {
            this.clientService.getById(this.id)
            .subscribe(req => {
              this.form.patchValue(req.data)
            });
        }

    }


    get fc() { return this.form.controls; }

    onSubmit() {
        this.submitted = true;

        this.alertService.clear();
        if (this.form.invalid) {
            return;
        }
        
        this.loading = true;
        if (this.isAddClient) {
            this.createUser();
        } else {
            this.updateUser();
        }
    }

    private createUser() {
        this.clientService.create(this.form.value)
            .subscribe(() => {
                this.alertService.success('Client created success', { keepAfterRouteChange: true });
                this.alertService.clear();
                this.form.reset();
                this.router.navigate(['../'], { relativeTo: this.route});
            })
            .add(() => this.loading = false);
    }

    private updateUser() {
        this.clientService.update(this.id, this.form.value)
            .subscribe(() => {
                this.alertService.success('Client updated success', { keepAfterRouteChange: true });
                this.alertService.clear();
                this.form.reset();
                this.router.navigate(['../../'], { relativeTo: this.route });
            })
            .add(() => this.loading = false);
    }
}