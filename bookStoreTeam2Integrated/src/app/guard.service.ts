import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Injectable({
  providedIn: 'root'
})
export class GuardService implements CanActivate {

  constructor(private route :Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | import("rxjs").Observable<boolean> | Promise<boolean> {
    if(localStorage.getItem("logged")=="loggedIn"){
      return true;
    }

    this.route.navigate(["/login"]);
    return false;
    
  }
}
