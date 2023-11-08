
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RiderDeliveryManager from "./components/listers/RiderDeliveryCards"
import RiderDeliveryDetail from "./components/listers/RiderDeliveryDetail"

import CustomerClientOrderManager from "./components/listers/CustomerClientOrderCards"
import CustomerClientOrderDetail from "./components/listers/CustomerClientOrderDetail"

import ShopShopOrderManager from "./components/listers/ShopShopOrderCards"
import ShopShopOrderDetail from "./components/listers/ShopShopOrderDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/riders/deliveries',
                name: 'RiderDeliveryManager',
                component: RiderDeliveryManager
            },
            {
                path: '/riders/deliveries/:id',
                name: 'RiderDeliveryDetail',
                component: RiderDeliveryDetail
            },

            {
                path: '/customers/clientOrders',
                name: 'CustomerClientOrderManager',
                component: CustomerClientOrderManager
            },
            {
                path: '/customers/clientOrders/:id',
                name: 'CustomerClientOrderDetail',
                component: CustomerClientOrderDetail
            },

            {
                path: '/shops/shopOrders',
                name: 'ShopShopOrderManager',
                component: ShopShopOrderManager
            },
            {
                path: '/shops/shopOrders/:id',
                name: 'ShopShopOrderDetail',
                component: ShopShopOrderDetail
            },



    ]
})
