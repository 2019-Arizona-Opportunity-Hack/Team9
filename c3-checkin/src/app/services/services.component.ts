import {Component, OnInit} from '@angular/core';
import {Service} from '../../models/service';
import {Member} from '../../models/member';
import {ServicesByMember} from '../../models/servicesByMember';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {
  selectedMember: Member;
  whoNeeds = [];
  selected = [];

  services = [
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

  constructor() {
    this.whoNeeds = JSON.parse(sessionStorage.getItem('whoNeeds'));
    this.selectedMember = this.whoNeeds.pop();
    sessionStorage.setItem('whoNeeds', JSON.stringify(this.whoNeeds, null, 4));
  }

  ngOnInit() {
    if (this.selectedMember == null) {
      window.location.href = '/login';
    }
  }

  select(service) {
    if (this.selected.includes(service)) {
      this.selected.splice(this.selected.indexOf(service), 1);
    } else {
      this.selected.push(service);
    }
  }

  isActive(service) {
    return this.selected.includes(service);
  }

  get member(): string {
    return this.selectedMember.name;
  }

  get btnName(): string {
    if (this.whoNeeds.length > 0) {
      return 'Next';
    } else {
      return 'Submit';
    }
  }

  onClick() {
    let services = [];
    const servicesByMember = [];
    const existingServicesByMember = JSON.parse(sessionStorage.getItem('servicesByMember'));

    if (existingServicesByMember !== null) {
      let i;
      for (i = 0; i < existingServicesByMember.length; i++) {
        services = [];
        let j;
        for (j = 0; j < existingServicesByMember[i].service.length; j++) {
          services.push(new Service(existingServicesByMember[i].service[j].id, existingServicesByMember[i].service[j].name));
        }
        servicesByMember.push(new ServicesByMember(existingServicesByMember[i].id, services));
      }
    }

    services = [];
    let k;
    for (k = 0; k < this.selected.length; k++) {
      services.push(new Service(this.selected[k].id, this.selected[k].name));
    }
    servicesByMember.push(new ServicesByMember(this.selectedMember.id, services));

    sessionStorage.setItem('servicesByMember', JSON.stringify(servicesByMember, null, 4));

    if (this.whoNeeds.length > 0) {
      window.location.href = '/services';
    } else {
      window.location.href = '/thanks';
    }
  }
}
