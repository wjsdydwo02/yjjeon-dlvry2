<template>

    <v-data-table
        :headers="headers"
        :items="menuDetail"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MenuDetailView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            menuDetail : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/menuDetails'))

            temp.data._embedded.menuDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.menuDetail = temp.data._embedded.menuDetails;
        },
        methods: {
        }
    }
</script>

