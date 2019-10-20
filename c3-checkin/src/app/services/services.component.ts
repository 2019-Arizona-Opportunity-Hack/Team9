import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Service} from '../../models/service';
import {Member} from '../../models/member';
import {ServicesByMember} from '../../models/servicesByMember';
import {ApiService} from '../api.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {
  selectedMember: Member;
  whoNeeds = [];
  selected = [];
  services = [];
  alreadyLoaded: any;

  constructor(private apiService: ApiService, private router: Router) {
    this.services = [];
    this.apiService.getServices()
      .subscribe((data) => {
        let i;
        // @ts-ignore
        for (i = 0; i < data.length; i++) {
          this.services.push(new Service(data[i].service_id, data[i].name));
        }
      });
  }

  ngOnInit() {
    if (!this.alreadyLoaded) {
      this.whoNeeds = JSON.parse(sessionStorage.getItem('whoNeeds'));
      this.selectedMember = this.whoNeeds.pop();
      sessionStorage.setItem('whoNeeds', JSON.stringify(this.whoNeeds, null, 4));

      this.selected = [];
      this.alreadyLoaded = true;
    }

    if (this.selectedMember == null) {
      this.router.navigate(['login']);
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

  goHome() {
    this.router.navigate(['login']);
  }

  onClick() {
    if (this.selected.length > 0) {
      let lservices = [];
      const servicesByMember = [];
      const existingServicesByMember = JSON.parse(sessionStorage.getItem('servicesByMember'));

      if (existingServicesByMember !== null) {
        let i;
        for (i = 0; i < existingServicesByMember.length; i++) {
          lservices = [];
          let j;
          for (j = 0; j < existingServicesByMember[i].service.length; j++) {
            lservices.push(new Service(existingServicesByMember[i].service[j].id, existingServicesByMember[i].service[j].name));
          }
          servicesByMember.push(new ServicesByMember(existingServicesByMember[i].id, lservices));
        }
      }

      lservices = [];
      let k;
      for (k = 0; k < this.selected.length; k++) {
        lservices.push(new Service(this.selected[k].id, this.selected[k].name));
      }
      servicesByMember.push(new ServicesByMember(this.selectedMember.id, lservices));
      sessionStorage.setItem('servicesByMember', JSON.stringify(servicesByMember, null, 4));

      if (this.whoNeeds.length > 0) {
        this.alreadyLoaded = false;
        this.ngOnInit();
      } else {
        // [
        //   {
        //     "member_id": "3fb6798c-c1cd-47d8-a123-49812f204cba",
        //     "service_id": "3fb6798c-c1cd-47d8-a123-49812f204cba",
        //     "created_date": "20191020T013132"
        //   }
        // ]

        // this.apiService.submitServicesByMember().subscribe((data) => {
        //   console.log(data);
        //
        //   this.router.navigate(['thanks']);
        // });

        this.router.navigate(['thanks']);
      }
    } else {
      alert('Please select the services needed.');
    }
  }
}
