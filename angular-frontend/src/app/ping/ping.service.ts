import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class PingService {

    constructor(private _http: Http) {}

    ping() {
        return this._http.get('http://localhost:8080/tree-model-rest/ping')
            .map((res:Response) => res.json());
    }
}
