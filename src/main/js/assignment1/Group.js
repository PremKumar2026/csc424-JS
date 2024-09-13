class Group {
    mySet;

    constructor() {
        this.mySet = [];
    }

    has(x) {
        return this.mySet.includes(x);
    }

    add(x) {
        if (!this.has(x)) {
            this.mySet.push(x);
        }
    }

    delete(x) {
        this.mySet = this.mySet.filter(item => item !== x);;
    }

    static from(it) {
        let result = new Group();
        for (let x of it) {
            result.add(x);
        }
        return result;
    }
}

function main() {
    let group = Group.from([10, 20]);
    console.log(group.has(10));
    // → true
    console.log(group.has(30));
    // → false
    group.add(10);
    group.delete(10);
    console.log(group.has(10));
    // → false
}

if (require.main === module) {
    main();
}

module.exports = Group;
