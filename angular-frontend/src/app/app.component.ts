import { Component, ViewEncapsulation } from '@angular/core';

@Component({
    selector: 'tree-model-system',
    template: '<router-outlet></router-outlet>',
    encapsulation: ViewEncapsulation.None
})
export class AppComponent {
    name = 'Tree Model System';
}
