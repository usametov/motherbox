(ns bookmarks.db)

(def bookmarks
 [
 {:last-modified #inst "2020-04-22T15:40:06.148-00:00",
  :date-added #inst "2016-11-21T08:02:07.271-00:00",
  :uri "http://ocw.mit.edu/courses/mathematics/",
  :title
  "Free Online Course Materials | Mathematics | MIT OpenCourseWare-- Mathematics in MIT - Available Courses\n ... ",
  :tags ["mathematics" "mit" "education"]}
 {:last-modified #inst "2020-04-22T15:40:05.989-00:00",
  :date-added #inst "2016-11-21T08:02:07.227-00:00",
  :uri
  "http://www.torontopubliclibrary.ca/detail.jsp?Entt=RDM3278725&R=3278725",
  :title
  "Understanding bitcoin : cryptography, engineering and economics : Franco, Pedro, author. : eBook : Toronto Public Library--",
  :tags
  ["cryptography"
   "bitcoins"
   "!torontopubliclibrary"
   "books"
   "torontopubliclibrary"]}
 {:last-modified #inst "2020-04-22T15:40:06.408-00:00",
  :date-added #inst "2016-12-24T19:10:29.000-00:00",
  :uri "https://www.learnrxjs.io/",
  :title "--",
  :tags ["rxjs" "tutorial"]}
 {:last-modified #inst "2020-04-22T15:40:06.094-00:00",
  :date-added #inst "2016-11-21T08:02:07.262-00:00",
  :uri "https://noggin.intel.com/books/intel-press-books/all",
  :title "Intel Press Books--",
  :tags ["books" "intel" "hardware" "c++" "ccode" "cpp"]}
 {:last-modified #inst "2019-05-04T02:00:04.108-00:00",
  :date-added #inst "2019-05-04T01:59:53.359-00:00",
  :uri "https://www.harshsikka.me/self-studying-the-mit-applied-math-curriculum/",
  :title "Self Studying the :MIT Applied :Math Curriculum",
  :tags #{"mit" "math"}}]
)

(def default-db
  {:name      "Company Name"
   :bookmarks bookmarks
   :filter-by ""})
