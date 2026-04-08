@RestController
@RequestMapping("/analyst")
@CrossOrigin("*")
public class AnalystController {

    @Autowired
    private AnalystService analystService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Analyst analyst) {
        Analyst a = analystService.verifyAnalystLogin(analyst.getEmail(), analyst.getPassword());
        if (a != null) return ResponseEntity.ok(a);
        else return ResponseEntity.status(401).body("Login Invalid");
    }

    @GetMapping("/viewallissues")
    public ResponseEntity<List<Issue>> viewAllIssues() {
        return ResponseEntity.ok(analystService.viewAllIssues());
    }

    @GetMapping("/viewallproblems")
    public ResponseEntity<List<Issue>> viewAllProblems() {
        return ResponseEntity.ok(analystService.viewAllProblems());
    }

    @PostMapping("/solveissue/{id}")
    public ResponseEntity<Issue> solveIssue(@PathVariable Long id) {
        return ResponseEntity.ok(analystService.solveIssue(id));
    }
}
