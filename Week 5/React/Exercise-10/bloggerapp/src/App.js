import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";
import "./App.css";

function App() {

    const showDetails = true;

    return (

        <div className="container">

            <div className="section">
                {showDetails && <CourseDetails />}
            </div>

            <div className="section">
                {showDetails ? <BookDetails /> : null}
            </div>

            <div className="section">
                <BlogDetails />
            </div>

        </div>

    );

}

export default App;