<template>

    <v-data-table
        :headers="headers"
        :items="riderPda"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'RiderPdaView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            riderPda : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/riderPdas'))

            temp.data._embedded.riderPdas.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.riderPda = temp.data._embedded.riderPdas;
        },
        methods: {
        }
    }
</script>

