import { Component, OnInit } from '@angular/core';
import { Service } from 'src/models/service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-report-service-selector',
  templateUrl: './report-service-selector.component.html',
  styleUrls: ['./report-service-selector.component.scss']
})
export class ReportServiceSelectorComponent implements OnInit {
  selected: Service = null;

  services: Service[] = [
    new Service(1, 'AHCCCS'),
    new Service(2, 'CLASSES'),
    new Service(3, 'DENTAL'),
    new Service(4, 'DIAPERS'),
    new Service(5, 'DENTAL SCREENING'),
    new Service(6, 'FOOD BANK'),
    new Service(7, 'IMMUNIZATIONS'),
    new Service(8, 'MEDICAL'),
    new Service(9, 'VISION & HEARING'),
    new Service(10, 'WIC'),
    new Service(11, 'THANKSGIVING'),
    new Service(12, 'TOY DISTRIBUTION'),
    new Service(13, 'THKG CHECK-IN'),
    new Service(14, 'XMAS CHECK-IN')
  ];

  constructor(private _router: Router) { }

  ngOnInit() {
  }

  select(service) {
    this.selected = service;
  }

  isActive(service) {
    return service === this.selected;
  }

  onNextClick() {
    sessionStorage.setItem('selectedReportService', JSON.stringify(this.selected, null, 4));
    this._router.navigate(['reportrun']);
  }
}
