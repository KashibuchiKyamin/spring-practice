import { gridjsLanguageConfig, gridjsStyleConfig } from "./myGridjsConfig.js";
const tableOfServerSide = new gridjs.Grid({
    columns: [
        "名前",
        "メールアドレス",
        {
            name: "電話番号",
            sort: false
        }
    ],
    sort: true,
    style: gridjsStyleConfig,
    language: gridjsLanguageConfig,
    server: {
        url: tableData,
        method: "GET",
        body: null,
        then: data => data.data.map(card => [card.name, card.email, card.phoneNumber]),
        handle: (res) => {
            // no matching records found
            if (res.status === 404) return { data: [] };
            if (res.ok) return res.json();

            throw Error("oh no :(");
        },
        total: (data) => data.total
    },
    sort: {
        multiColumn: false,
        server: {
            url: () => tableData,
            body: (prev, columns) => {
                console.log(`sort-prev:${prev}`);
                console.log(`sort-columns:${columns}`);
                return null;
            }
        }
    },
    pagination: {
        limit: 5,
        server: {
            url: () => tableData,
            body: (prev, page, limit) => {
                console.log(`pagination-prev:${prev}`);
                console.log(`pagination-page:${page}`);
                console.log(`pagination-limit:${limit}`);
                return null;
            }
        }
    }
}).render(document.getElementById("gridjs-table"));



const tableOfStatic = new gridjs.Grid({

    columns: [
        {
            id: "name",
            name: "名前",
        },
        {
            id: "email",
            name: "メールアドレス",
        },
        {
            id: "phoneNumber",
            name: "電話番号"
        }
    ],
    sort: false,
    style: gridjsStyleConfig,
    language: gridjsLanguageConfig,
    data: [
        { name: "John", email: "john@example.com", phoneNumber: "(353) 01 222 3333" },
        { name: "Mark", email: "mark@gmail.com", phoneNumber: "(01) 22 888 4444" },
        { name: "Eoin", email: "eo3n@yahoo.com", phoneNumber: "0097 22 654 00033" },
        { name: "Nisen", email: "nis900@gmail.com", phoneNumber: "000-0000-0000" }
    ]
}).render(document.getElementById("gridjs-table-static"));
