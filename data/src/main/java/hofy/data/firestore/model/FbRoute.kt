package hofy.data.firestore.model

class FbRoute() {
    constructor(name: String?, length: Int?, grade: String?) : this() {
        this.name = name
        this.length = length
        this.grade = grade
    }

    var name: String? = null
    var length: Int? = null
    var grade: String? = null


}