import { Component, OnInit } from '@angular/core';
import { Service } from 'src/models/service';
import { Router } from '@angular/router';
import { C3ApiService } from '../c3-api.service';

@Component({
  selector: 'app-report-service-selector',
  templateUrl: './report-service-selector.component.html',
  styleUrls: ['./report-service-selector.component.scss']
})
export class ReportServiceSelectorComponent implements OnInit {
  selected: Service = null;
  services;

  constructor(private router: Router, private c3services: C3ApiService) { }

  ngOnInit() {
    this.c3services.getServices().subscribe(results => this.services = results);
  }

  select(service) {
    this.selected = service;
  }

  isActive(service) {
    return service === this.selected;
  }

  onNextClick() {
    sessionStorage.setItem('selectedReportService', JSON.stringify(this.selected, null, 4));
    this.router.navigate(['reportrun']);
  }
}
