@RestController
@RequestMapping("/analyst")
@CrossOrigin("*")
public class AnalystController {

    @Autowired
    private AnalystService analystService;

    // 🔐 Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Analyst analyst) {
        Analyst a = analystService.verifyAnalystLogin(analyst.getEmail(), analyst.getPassword());
        if (a != null) return ResponseEntity.ok(a);
        else return ResponseEntity.status(401).body("Login Invalid");
    }

    // 📋 View all issues
    @GetMapping("/viewallissues")
    public ResponseEntity<List<Issue>> viewAllIssues() {
        return ResponseEntity.ok(analystService.viewAllIssues());
    }

    // ⚠️ View only problems (critical issues)
    @GetMapping("/viewallproblems")
    public ResponseEntity<List<Issue>> viewAllProblems() {
        return ResponseEntity.ok(analystService.viewAllProblems());
    }

    // ✅ Solve issue
    @PostMapping("/solveissue/{id}")
    public ResponseEntity<Issue> solveIssue(@PathVariable Long id) {
        return ResponseEntity.ok(analystService.solveIssue(id));
    }

    // 🔍 Fraud Detection
    @GetMapping("/fraud-detection")
    public ResponseEntity<String> detectFraud() {
        return ResponseEntity.ok(analystService.detectFraud());
    }

    // 📈 Voting Trend Analysis
    @GetMapping("/trend-analysis")
    public ResponseEntity<String> getTrends() {
        return ResponseEntity.ok(analystService.analyzeTrends());
    }

    // 🔄 Issue Status Tracking
    @PutMapping("/update-status/{id}")
    public ResponseEntity<Issue> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(analystService.updateIssueStatus(id, status));
    }

    // 🗺️ Region-wise Monitoring
    @GetMapping("/region/{region}")
    public ResponseEntity<List<Issue>> getIssuesByRegion(@PathVariable String region) {
        return ResponseEntity.ok(analystService.getIssuesByRegion(region));
    }

    // 📊 Dashboard Stats
    @GetMapping("/dashboard")
    public ResponseEntity<?> getDashboard() {
        return ResponseEntity.ok(analystService.getDashboardStats());
    }

    // 📄 Generate Report
    @GetMapping("/report")
    public ResponseEntity<String> generateReport() {
        return ResponseEntity.ok(analystService.generateReport());
    }
}
