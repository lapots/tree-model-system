import { Component, OnInit, OnDestroy } from '@angular/core';
import { PingService } from './ping.service';

@Component({
    selector: 'ping',
    templateUrl: 'ping.component.html',
    providers: [PingService]
})
export class PingComponent implements OnInit, OnDestroy {

    // vars
    private pingResponse: string;
    private _subscription;

    // constructor
    constructor(private _pingService: PingService) {}

    // on-init
    ngOnInit() {
        // save _subscription
        this._subscription = this._pingService.ping()
            .subscribe(
                (data) => {
                    this.pingResponse = JSON.stringify(data);
                },
                (err) => console.log(err),
                () => console.log('ping service test complete')
        );
    }

    // on-destroy
    ngOnDestroy() {
        // unsubscribe
        this._subscription.unsubscribe();
    }
}
